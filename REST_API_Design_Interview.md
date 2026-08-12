# REST API Design Interview Cheat Sheet

For a 2-3 year Software Developer / Full-Stack Developer interview. This sheet focuses on API design concepts that apply to any backend. It avoids Spring, SQL, and framework-specific implementation details.

## 1. Priority Map

| Level | Topics |
| --- | --- |
| MUST KNOW | REST basics, resource naming, statelessness, HTTP methods, safe/idempotent methods, status codes, request/response shape, auth vs authorization, JWT basics, pagination, filtering, error responses, idempotency, versioning, API security |
| SHOULD KNOW | Cursor pagination, `ETag`, conditional requests, webhooks, retries/backoff, rate limiting, long-running operations, bulk endpoints |
| BASIC | URI vs URL, REST vs SOAP, `HEAD`/`OPTIONS`, CORS basics, caching basics |

## 2. REST Fundamentals

**MUST KNOW**

**Definition:** REST is an architectural style for designing network APIs around resources, standard HTTP methods, stateless requests, and representations such as JSON.

**Why it matters:** It makes APIs predictable, scalable, and easy for clients to consume.

**Interview-ready answer:** "REST APIs expose resources through URLs and use HTTP methods like GET, POST, PUT, PATCH, and DELETE to operate on them. Each request should contain enough information for the server to process it."

```http
GET /api/products/42
Accept: application/json
```

**Trap/follow-up:** REST is not just "JSON over HTTP." It is about resource-oriented design and HTTP semantics.

**When use it?** CRUD-style APIs, public APIs, backend-for-frontend APIs, internal services, and integrations.

## 3. REST Request / Response Flow

```mermaid
sequenceDiagram
  participant C as Client
  participant API as REST API
  participant Auth as Auth Layer
  participant S as Service
  participant DB as Data Store
  C->>API: HTTP request
  API->>Auth: Authenticate + authorize
  Auth-->>API: Allowed / denied
  API->>S: Validate + process
  S->>DB: Read/write data
  DB-->>S: Result
  S-->>API: Domain result
  API-->>C: Status + headers + JSON body
```

**Interview answer:** "The request is authenticated, authorized, validated, processed by business logic, and returned with the right status code, headers, and response body."

## 4. REST Principles

**MUST KNOW**

| Principle | Meaning |
| --- | --- |
| Client-server | UI and backend responsibilities are separated |
| Stateless | Server does not rely on hidden client session state per request |
| Resource-oriented | URLs represent resources, not actions |
| Uniform interface | Standard methods/status codes/media types |
| Cacheable | Responses can define caching behavior |
| Layered system | Proxies/gateways/load balancers can sit between client and server |

**Interview-ready answer:** "For interviews, the most practical REST principles are resource-oriented URLs, stateless requests, standard HTTP methods, correct status codes, and consistent representations."

```http
GET /api/users/123/orders
```

**Trap:** Using action URLs everywhere, like `/getUser` or `/deleteProduct`, instead of resources.

## 5. Resource-Oriented Design and Naming

**MUST KNOW**

**Definition:** APIs should model important nouns as resources and expose collections/items with clear paths.

**Why it matters:** Resource names make APIs consistent and easy to guess.

**Interview-ready answer:** "I use plural nouns for collections, IDs for individual resources, and nest resources only for real parent-child relationships."

```http
GET    /api/users
POST   /api/users
GET    /api/users/123
PATCH  /api/users/123
DELETE /api/users/123

GET    /api/users/123/orders
```

**Trap:** Deep nesting like `/companies/1/departments/2/teams/3/users/4/orders/5` becomes hard to maintain.

**When use it?** Always when designing REST endpoints.

## 6. URI / URL Basics

**BASIC**

**Definition:** A URI identifies a resource. A URL is a URI that also gives its network location.

**Why it matters:** APIs use URLs as resource identifiers.

**Interview-ready answer:** "In everyday API discussion, URL usually means the endpoint path plus host, while URI is the broader identifier concept."

```text
https://api.example.com/v1/products/42?include=reviews
```

**Trap:** Query parameters should refine a collection request, not identify a core resource that belongs in the path.

## 7. REST vs SOAP

**BASIC**

| REST | SOAP |
| --- | --- |
| Architectural style | Protocol |
| Commonly JSON over HTTP | XML envelope |
| Uses HTTP methods naturally | Operation/message based |
| Lightweight and common for web/mobile | Strong formal contracts, enterprise legacy |
| Easier for frontend apps | More rigid tooling |

**Interview-ready answer:** "REST is simpler and resource-oriented, commonly using JSON and HTTP methods. SOAP is a protocol with XML envelopes and formal contracts, often found in enterprise systems."

**Trap:** SOAP can use HTTP, but it does not use HTTP resource semantics the same way REST does.

## 8. HTTP Methods

**MUST KNOW**

| Method | Purpose | Safe | Idempotent |
| --- | --- | --- | --- |
| `GET` | Read resource | Yes | Yes |
| `POST` | Create/process action | No | No by default |
| `PUT` | Replace resource | No | Yes |
| `PATCH` | Partially update resource | No | Not guaranteed |
| `DELETE` | Delete resource | No | Yes |
| `HEAD` | Like GET without body | Yes | Yes |
| `OPTIONS` | Communication options/preflight | Yes | Yes |

**Interview-ready answer:** "GET reads, POST creates or triggers processing, PUT replaces, PATCH partially updates, DELETE removes. Safe means no requested state change; idempotent means repeating the request has the same final effect."

**Trap:** Idempotent does not mean "same response every time." DELETE can return `204` first and `404` later, but the final state is still deleted.

## 9. GET vs POST

**MUST KNOW**

| GET | POST |
| --- | --- |
| Retrieve data | Create resource or process command |
| Safe | Unsafe |
| Idempotent | Not idempotent by default |
| Parameters usually in query | Data usually in body |
| Cacheable by default semantics | Cacheable only with explicit headers |

```http
GET /api/products?category=books

POST /api/products
Content-Type: application/json

{ "name": "Keyboard", "price": 2999 }
```

**Trap:** Do not use GET for actions like `/sendEmail` or `/createOrder`; crawlers/prefetchers may call GET.

## 10. PUT vs PATCH

**MUST KNOW**

| PUT | PATCH |
| --- | --- |
| Replaces full resource | Applies partial update |
| Idempotent by definition | Not necessarily idempotent |
| Client sends complete representation | Client sends changed fields/patch document |
| Missing fields may be cleared | Missing fields usually unchanged |

```http
PUT /api/users/123
Content-Type: application/json

{ "name": "Asha", "email": "asha@example.com", "role": "USER" }
```

```http
PATCH /api/users/123
Content-Type: application/json

{ "email": "new@example.com" }
```

**Trap:** Treating PUT as partial update confuses clients.

## 11. PUT vs POST Idempotency

**MUST KNOW**

| Topic | PUT | POST |
| --- | --- | --- |
| Target | Known resource URI | Collection or processing endpoint |
| Repeat effect | Same final state | May create/process multiple times |
| Example | `PUT /users/123` | `POST /users` |

**Interview-ready answer:** "PUT is idempotent because repeating the same replacement should leave the resource in the same state. POST is not idempotent unless the API adds idempotency keys."

**Trap:** `POST /orders` retried after timeout can create duplicate orders unless designed for idempotency.

## 12. HTTP Status Codes

**MUST KNOW**

| Code | Meaning | Common API use |
| --- | --- | --- |
| `200 OK` | Request succeeded | Successful read/update with body |
| `201 Created` | New resource created | POST create |
| `202 Accepted` | Accepted for async processing | Long-running job |
| `204 No Content` | Success with no body | Delete/update no response body |
| `400 Bad Request` | Malformed/invalid request | Bad JSON/query/required data |
| `401 Unauthorized` | Missing/invalid authentication | Login required |
| `403 Forbidden` | Authenticated but not allowed | No permission |
| `404 Not Found` | Resource not found | Unknown ID/path |
| `405 Method Not Allowed` | Method unsupported for resource | POST to read-only endpoint |
| `409 Conflict` | State conflict | Duplicate email/version conflict |
| `422 Unprocessable Content` | Semantically invalid content | Validation understood but fails |
| `429 Too Many Requests` | Rate limit exceeded | Throttling |
| `500 Internal Server Error` | Server bug/unexpected error | Unhandled failure |
| `502 Bad Gateway` | Invalid upstream response | Gateway/downstream issue |
| `503 Service Unavailable` | Temporary overload/maintenance | Retry later |

**Interview-ready answer:** "Use 2xx for success, 4xx for client/action problems, and 5xx for server or downstream failures."

**Trap:** Do not return `200 OK` for every error with `{ success: false }`.

## 13. 200 vs 201 vs 204

**MUST KNOW**

| Code | Use |
| --- | --- |
| `200` | Success with response body |
| `201` | New resource created, often with `Location` header |
| `204` | Success with no response body |

```http
HTTP/1.1 201 Created
Location: /api/products/42
Content-Type: application/json

{ "id": 42, "name": "Keyboard" }
```

**Trap:** `204` must not include a response body.

## 14. 401 vs 403

**MUST KNOW**

| 401 Unauthorized | 403 Forbidden |
| --- | --- |
| Not authenticated or invalid credentials | Authenticated but lacks permission |
| Client may login/refresh token | Login will not fix permission |
| Often includes `WWW-Authenticate` | No auth challenge required |

**Interview-ready answer:** "401 means the API does not know who you are or credentials are invalid. 403 means it knows who you are, but you are not allowed."

**Trap:** The word "Unauthorized" in 401 is historically confusing; it really means unauthenticated.

## 15. 400 vs 422

**SHOULD KNOW**

| 400 Bad Request | 422 Unprocessable Content |
| --- | --- |
| Malformed syntax or generally invalid request | Valid syntax but semantic validation failed |
| Bad JSON, invalid query format | Email format invalid, business field validation |
| Broad and widely used | Useful for field-level validation APIs |

**Interview-ready answer:** "400 is always acceptable for invalid client input. Some APIs use 422 when the JSON is syntactically valid but validation rules fail."

**Trap:** Be consistent and document your API's choice.

## 16. Request / Response Design

**MUST KNOW**

**Definition:** Request/response design defines how clients send data and how APIs return data, errors, headers, and metadata.

**Why it matters:** Consistent structure reduces frontend bugs and improves API usability.

```http
POST /api/users
Content-Type: application/json
Accept: application/json
Authorization: Bearer eyJ...

{
  "name": "Asha",
  "email": "asha@example.com"
}
```

```json
{
  "id": "usr_123",
  "name": "Asha",
  "email": "asha@example.com",
  "createdAt": "2026-08-12T10:30:00Z"
}
```

**Interview-ready answer:** "I keep paths resource-based, use query params for filtering/sorting/pagination, body for create/update data, headers for metadata/auth/content negotiation, and consistent JSON responses."

**Trap:** Mixing response shapes randomly makes clients fragile.

## 17. Path, Query, Headers, Body

**MUST KNOW**

| Part | Use |
| --- | --- |
| Path parameter | Identify a resource |
| Query parameter | Filter, search, sort, paginate, include options |
| Header | Auth, content type, caching, request metadata |
| Body | Create/update payload |

```http
GET /api/products/42/reviews?sort=-createdAt&limit=20
Accept: application/json
Authorization: Bearer token
```

**Trap:** Do not put access tokens or sensitive data in query strings; they can appear in logs/history.

## 18. Content-Type and Accept

**BASIC**

**Definition:** `Content-Type` says what the request/response body is. `Accept` says what response media type the client prefers.

**Why it matters:** APIs and clients need to agree on JSON, file uploads, or other formats.

```http
Content-Type: application/json
Accept: application/json
```

**Interview-ready answer:** "`Content-Type` describes the body being sent. `Accept` describes what the client wants back."

**Trap:** Missing or wrong `Content-Type` can cause the server to reject or misread the body.

## 19. Consistent Response Format

**SHOULD KNOW**

**Definition:** Similar endpoints should return predictable JSON shapes.

**Why it matters:** Frontend and mobile clients can handle responses consistently.

```json
{
  "data": {
    "id": "prd_42",
    "name": "Keyboard"
  }
}
```

```json
{
  "data": [
    { "id": "prd_1", "name": "Mouse" }
  ],
  "pagination": {
    "limit": 20,
    "nextCursor": "eyJpZCI6..."
  }
}
```

**Interview-ready answer:** "I keep success responses simple and consistent. For lists, I include pagination metadata. For errors, I return a separate error object."

**Trap:** Over-wrapping every response can add noise; consistency matters more than one universal envelope.

## 20. Error Response Format

**MUST KNOW**

**Definition:** A good error response gives a stable code, human-readable message, and optional field details.

**Why it matters:** Clients need to show useful messages and handle errors programmatically.

```json
{
  "error": {
    "code": "VALIDATION_ERROR",
    "message": "Request validation failed",
    "fields": {
      "email": "Email is invalid",
      "password": "Password must be at least 8 characters"
    },
    "requestId": "req_abc123"
  }
}
```

**Interview-ready answer:** "I return the right status code plus a consistent error body with a machine-readable code, safe message, field errors when relevant, and a request ID for debugging."

**Trap:** Never expose stack traces, SQL errors, or secrets in API responses.

## 21. Authentication vs Authorization

**MUST KNOW**

| Authentication | Authorization |
| --- | --- |
| Verifies identity | Checks permissions |
| "Who are you?" | "What can you access?" |
| Login/session/JWT | Roles, scopes, policies |
| 401 when missing/invalid | 403 when insufficient permission |

**Interview-ready answer:** "Authentication identifies the user. Authorization decides whether that user can perform the action on the resource."

```mermaid
flowchart LR
  Req[Request] --> AuthN{Authenticated?}
  AuthN -->|No| R401[401]
  AuthN -->|Yes| AuthZ{Allowed?}
  AuthZ -->|No| R403[403]
  AuthZ -->|Yes| Handler[Process request]
```

**Trap:** Hiding buttons in the frontend is not authorization. The backend must enforce it.

## 22. Session vs Token Authentication

**MUST KNOW**

**Definition:** Session auth stores login state on the server and usually uses a cookie. Token auth sends a token, often a JWT, with each request.

**Why it matters:** Web apps, SPAs, mobile apps, and APIs choose auth approaches differently.

| Session | Token/JWT |
| --- | --- |
| Server stores session | Server verifies token |
| Usually cookie-based | Usually `Authorization: Bearer` |
| Easy invalidation | Stateless verification |
| CSRF considerations | XSS/token storage considerations |

**Interview-ready answer:** "Sessions are server-side login state, usually cookie-based. Tokens are sent with each request and can be used for stateless APIs."

**Trap:** JWT is not automatically more secure; storage, expiry, refresh, and revocation matter.

## 23. JWT Basics

**MUST KNOW**

**Definition:** JWT is a signed token containing claims, commonly used as a bearer access token.

**Why it matters:** Many APIs use JWTs for stateless authentication.

```mermaid
sequenceDiagram
  participant C as Client
  participant API as API
  C->>API: Login credentials
  API-->>C: accessToken + refreshToken
  C->>API: GET /me Authorization: Bearer accessToken
  API->>API: Verify signature + expiry + claims
  API-->>C: User data
```

```http
Authorization: Bearer eyJhbGciOiJIUzI1NiIs...
```

**Interview-ready answer:** "A JWT is signed, not encrypted by default. The API verifies its signature and expiry, then uses claims like user ID, roles, or scopes."

**Trap:** Do not put secrets or sensitive personal data in JWT claims.

## 24. Access Token vs Refresh Token

**MUST KNOW**

| Access token | Refresh token |
| --- | --- |
| Used to call APIs | Used to get new access token |
| Short-lived | Longer-lived |
| Sent often | Stored more carefully |
| Contains auth claims | Usually opaque or tightly protected |

**Interview-ready answer:** "Access tokens should be short-lived. Refresh tokens last longer and are used to renew access without asking the user to log in again."

**Trap:** If refresh tokens are stolen, attackers can keep getting access tokens. Protect and rotate them.

## 25. Role-Based Authorization

**MUST KNOW**

**Definition:** Role-based authorization grants access based on roles like `ADMIN`, `USER`, or `MANAGER`.

**Why it matters:** Most business APIs need protected endpoints/actions.

```http
GET /api/admin/users
Authorization: Bearer token-with-admin-role
```

**Interview-ready answer:** "I check authorization on the server by comparing the authenticated user's roles/scopes/ownership against the requested action and resource."

**Trap:** Role checks alone may be insufficient. You may also need resource ownership checks like "user owns this order."

## 26. Pagination, Filtering, Sorting, Search

**MUST KNOW**

**Definition:** List APIs should let clients request small, relevant, ordered subsets of data.

**Why it matters:** Large lists are slow, expensive, and bad for UX.

```http
GET /api/products?category=books&minPrice=100&sort=-createdAt&limit=20&offset=40
```

```json
{
  "data": [{ "id": "prd_1", "name": "Book" }],
  "pagination": {
    "limit": 20,
    "offset": 40,
    "total": 240
  }
}
```

**Interview-ready answer:** "I support filtering and sorting through query parameters, enforce max page size, and include pagination metadata."

**Trap:** Never return unlimited collections.

## 27. Offset vs Cursor Pagination

**MUST KNOW**

| Offset pagination | Cursor/keyset pagination |
| --- | --- |
| `?limit=20&offset=40` | `?limit=20&cursor=abc` |
| Simple and jump-to-page friendly | Stable and efficient for large changing data |
| Can be slow for deep pages | Harder to jump to exact page number |
| Can duplicate/miss rows if data changes | Better for infinite scroll/feed |

```mermaid
flowchart LR
  A[Client requests first page] --> B[API returns items + nextCursor]
  B --> C[Client sends nextCursor]
  C --> D[API returns next slice]
  D --> E[Repeat until no cursor]
```

**Interview-ready answer:** "Offset is fine for small admin tables. Cursor pagination is better for millions of records, feeds, and data that changes while users paginate."

**Trap:** Cursor values should be opaque to clients.

## 28. Error Handling

**MUST KNOW**

**Definition:** Error handling maps different failure types to appropriate status codes and safe response bodies.

**Why it matters:** Clients need predictable behavior, and servers must not leak internals.

| Error type | Status | Example |
| --- | --- | --- |
| Validation | `400` or `422` | Invalid email |
| Authentication | `401` | Missing/expired token |
| Authorization | `403` | User lacks role |
| Not found | `404` | Unknown resource ID |
| Conflict | `409` | Duplicate email/order already processed |
| Rate limit | `429` | Too many requests |
| Unexpected server | `500` | Unhandled bug |
| Downstream unavailable | `502`/`503` | Payment service down |

**Interview-ready answer:** "I separate validation, business, auth, and server errors, return clear status codes, and use a consistent error format."

**Trap:** Catching every error and returning `500` hides client mistakes and makes debugging harder.

## 29. Idempotency

**MUST KNOW**

**Definition:** An operation is idempotent if repeating it has the same final effect as doing it once.

**Why it matters:** Networks fail. Clients retry. APIs must avoid duplicate payments, orders, and side effects.

```mermaid
sequenceDiagram
  participant C as Client
  participant API as API
  participant Store as Idempotency Store
  C->>API: POST /orders Idempotency-Key: uuid-1
  API->>Store: Has key uuid-1?
  Store-->>API: No
  API->>API: Create order
  API->>Store: Save result for uuid-1
  API-->>C: Timeout / lost response
  C->>API: Retry same key
  API->>Store: Has key uuid-1?
  Store-->>API: Yes
  API-->>C: Return original result
```

```http
POST /api/payments
Idempotency-Key: 8e03978e-7f61-4f0f-9c9b-a987c6f4a2db
Content-Type: application/json

{ "orderId": "ord_123", "amount": 4999 }
```

**Interview-ready answer:** "GET, PUT, and DELETE are idempotent by HTTP semantics. POST is not, so for payment/order creation I use an idempotency key and store the first result."

**Trap:** Idempotency key must be tied to the same request parameters; reusing the key with different data should be rejected.

## 30. API Versioning

**MUST KNOW**

**Definition:** Versioning lets APIs evolve without breaking existing clients.

**Why it matters:** Mobile apps and external clients may not update immediately.

| Versioning style | Example | Notes |
| --- | --- | --- |
| URL versioning | `/api/v1/users` | Simple and visible |
| Header versioning | `Accept: application/vnd.app.v2+json` | Cleaner URLs, more hidden |
| Query versioning | `?version=1` | Easy but less common for public APIs |

**Interview-ready answer:** "I avoid breaking changes when possible. If I must change request/response contracts, I introduce a new version and support old clients during migration."

**Breaking changes:** Renaming/removing fields, changing field type, changing auth behavior, changing endpoint meaning.

**Non-breaking changes:** Adding optional fields, adding new endpoints, adding optional query params.

**Trap:** Adding a required request field is a breaking change.

## 31. API Security

**MUST KNOW**

**Definition:** API security protects data and actions through transport security, identity, permissions, validation, limits, and safe error handling.

**Why it matters:** APIs are exposed attack surfaces.

| Practice | Why |
| --- | --- |
| HTTPS only | Protect data in transit |
| Strong authentication | Know caller identity |
| Server-side authorization | Enforce permissions |
| Input validation | Reject bad/malicious data |
| Rate limiting | Reduce abuse |
| CORS allowlist | Control browser access |
| Avoid sensitive data exposure | Reduce leak impact |
| Safe error messages | Avoid revealing internals |
| Parameterized DB access | Prevent injection |

**Interview-ready answer:** "I secure APIs with HTTPS, auth, server-side authorization, validation, rate limits, safe CORS, and careful error responses. I never trust frontend-only checks."

**Trap:** CORS is not backend authorization. Non-browser clients can bypass CORS entirely.

## 32. CORS Basics

**BASIC**

**Definition:** CORS is a browser mechanism where the server tells browsers which origins may read cross-origin responses.

**Why it matters:** React apps often run on a different domain from the API.

```http
Access-Control-Allow-Origin: https://app.example.com
Access-Control-Allow-Methods: GET, POST, PATCH, DELETE
Access-Control-Allow-Headers: Authorization, Content-Type
```

**Interview-ready answer:** "CORS controls browser cross-origin reads. It should allow only trusted origins, especially when credentials are involved."

**Trap:** `Access-Control-Allow-Origin: *` must not be used with credentialed private APIs.

## 33. Webhooks

**SHOULD KNOW**

**Definition:** A webhook is an HTTP callback sent by one system to notify another system about an event.

**Why it matters:** It avoids constant polling for external events like payments, delivery status, or GitHub events.

| Polling | Webhook |
| --- | --- |
| Client repeatedly asks for updates | Provider sends event when it happens |
| Simple but wasteful | Efficient and near-real-time |
| Client controls schedule | Provider controls delivery |
| Good for simple status checks | Good for event-driven integrations |

```mermaid
sequenceDiagram
  participant Provider as Payment Provider
  participant API as Your API
  participant DB as Database
  Provider->>API: POST /webhooks/payment event + signature
  API->>API: Verify signature
  API->>API: Check idempotency/event ID
  API->>DB: Update order/payment status
  API-->>Provider: 2xx acknowledgement
```

**Interview-ready answer:** "A webhook is a server-to-server event notification. I verify the signature, process idempotently, return 2xx only after accepting it, and handle retries."

**Trap:** Never trust webhook payloads without signature verification.

## 34. Webhook Security and Retry Handling

**SHOULD KNOW**

**Definition:** Webhook security verifies the sender and prevents duplicate or replayed processing.

**Why it matters:** Webhooks can create payments, activate accounts, or change order status.

```http
POST /api/webhooks/stripe
Stripe-Signature: t=...,v1=...
Content-Type: application/json
```

**Interview-ready answer:** "I verify provider signature using the raw body, store event IDs to avoid duplicate processing, respond quickly, and use background jobs for heavy work."

**Trap:** Parsing/modifying the body before signature verification can break verification.

## 35. Performance and Reliability

**MUST KNOW**

**Definition:** API reliability means APIs behave predictably under load, network failure, downstream slowness, and client retries.

**Why it matters:** Real systems fail partially.

| Technique | Use |
| --- | --- |
| Caching | Avoid repeated expensive reads |
| `ETag` / conditional requests | Avoid sending unchanged data |
| Rate limiting | Protect service from abuse |
| Timeouts | Avoid hanging forever |
| Retries with backoff | Recover from transient failures |
| Smaller payloads | Reduce bandwidth and latency |
| Batch endpoints | Avoid many small calls |
| Async processing | Handle long-running jobs |

**Interview-ready answer:** "I reduce payloads, paginate, cache safe reads, set timeouts, retry only safe/idempotent operations, use backoff, and avoid N+1 API calls."

**Trap:** Retrying non-idempotent POST without an idempotency key can duplicate side effects.

## 36. Caching, ETag, Conditional Requests

**SHOULD KNOW**

**Definition:** Caching stores responses for reuse. `ETag` is a resource version identifier used with conditional headers like `If-None-Match`.

**Why it matters:** It saves bandwidth and reduces server load.

```http
GET /api/products/42

HTTP/1.1 200 OK
ETag: "product-42-v7"
Cache-Control: private, max-age=60
```

```http
GET /api/products/42
If-None-Match: "product-42-v7"

HTTP/1.1 304 Not Modified
```

**Interview-ready answer:** "For cacheable GET responses, I use cache headers and ETags. Clients can send `If-None-Match`; if unchanged, the server returns `304 Not Modified`."

**Trap:** Do not cache private user data publicly.

## 37. Timeouts, Retries, Backoff

**MUST KNOW**

**Definition:** Timeouts stop waiting forever; retries repeat failed requests; exponential backoff increases delay between retries.

**Why it matters:** Downstream services and networks can fail temporarily.

```text
Retry delays: 500ms -> 1s -> 2s -> 4s + jitter
```

**Interview-ready answer:** "I set timeouts, retry only transient failures, use exponential backoff with jitter, and make retried operations idempotent."

**Trap:** Retrying every 500 error aggressively can make an outage worse.

## 38. Long-Running Operations

**SHOULD KNOW**

**Definition:** Long operations should often be accepted asynchronously and tracked through a status endpoint.

**Why it matters:** Clients should not wait on HTTP connections for minutes.

```http
POST /api/reports

HTTP/1.1 202 Accepted
Location: /api/jobs/job_123

{ "jobId": "job_123", "status": "QUEUED" }
```

```http
GET /api/jobs/job_123
```

**Interview-ready answer:** "For long-running work, I return `202 Accepted` with a job/status URL. The client polls or receives a webhook/event when complete."

**Trap:** `202` means accepted, not completed.

## 39. Bulk / Batch Endpoints and N+1 API Calls

**SHOULD KNOW**

**Definition:** N+1 API calls happen when a client makes one list call and then one call per item.

**Why it matters:** It hurts latency and backend load.

```http
GET /api/products?ids=1,2,3,4
GET /api/orders?include=items
```

**Interview-ready answer:** "I reduce N+1 API calls by supporting include parameters, batch endpoints, or purpose-built endpoints for the screen."

**Trap:** Overusing `include=*` can create huge payloads.

## 40. API Design Scenarios

### A. Design APIs for user management.

Use resource endpoints:

```http
POST   /api/users
GET    /api/users/{id}
GET    /api/users?role=ADMIN&limit=20
PATCH  /api/users/{id}
DELETE /api/users/{id}
```

Use DTOs, validation, `201` on create, `404` for missing user, `409` for duplicate email, and authorization for admin-only actions.

### B. Design CRUD APIs for products.

```http
GET    /api/products?category=books&sort=-createdAt&limit=20
POST   /api/products
GET    /api/products/{id}
PUT    /api/products/{id}
PATCH  /api/products/{id}
DELETE /api/products/{id}
```

Return `201` for create, `200` for read/update with body, `204` for delete without body.

### C. Pagination for millions of records.

Use cursor/keyset pagination with stable sort fields.

```http
GET /api/events?limit=50&cursor=eyJjcmVhdGVkQXQiOiIyMDI2...
```

Return `nextCursor`, enforce max limit, and index the sort/filter fields.

### D. PUT vs PATCH?

Use PUT when the client sends the complete replacement. Use PATCH when the client sends partial changes.

### E. Resource does not exist?

Return `404 Not Found`. For unauthorized private resources, some APIs intentionally return `404` to avoid revealing existence.

### F. 401 vs 403?

Return `401` for missing/invalid auth. Return `403` when authenticated but not allowed.

### G. Prevent duplicate payment/order creation on retry.

Use `Idempotency-Key`, store the first result, compare request parameters, and return the same result for retries.

### H. Search/filter/sort API.

```http
GET /api/products?q=keyboard&category=electronics&minPrice=1000&sort=-rating,price&limit=20
```

Validate allowed filters/sort fields and avoid exposing internal fields.

### I. Handle validation errors.

Return `400` or `422` with field-level errors and a stable error code.

### J. Version without breaking clients.

Avoid breaking changes first. Add optional fields/endpoints. For breaking changes, introduce `/v2` or versioned media type and support migration.

### K. Secure a webhook.

Verify signature using raw body, check timestamp, store event ID for idempotency, process quickly, and return 2xx only after accepting.

### L. Slow downstream service.

Use timeout, circuit breaker style protection where available, fallback if safe, async job for long work, and clear `503`/retry behavior.

### M. Long-running operation.

Return `202 Accepted` with `Location` pointing to a job status resource.

## 41. Most-Asked REST API Interview Questions

### A. What is REST?

REST is a resource-oriented architectural style using standard HTTP methods, stateless requests, and representations like JSON.

### B. What does stateless mean?

Each request contains the information needed to process it; the server does not rely on hidden client conversation state.

### C. GET vs POST?

GET reads data and should be safe/idempotent. POST creates or triggers processing and is not idempotent by default.

### D. PUT vs PATCH?

PUT replaces a resource. PATCH partially updates it.

### E. Which methods are idempotent?

GET, HEAD, OPTIONS, PUT, and DELETE are idempotent by HTTP semantics. POST and PATCH are not guaranteed idempotent.

### F. Difference between 401 and 403?

401 means missing/invalid authentication. 403 means authenticated but not allowed.

### G. When use 201?

When a new resource is created, usually after POST, often with a `Location` header.

### H. When use 202?

When the request is accepted for async processing but not completed yet.

### I. How design pagination?

Use offset for simple small lists; cursor/keyset for large or changing datasets. Return metadata and enforce limits.

### J. What is an idempotency key?

A unique client-provided key that lets the server return the same result for retried non-idempotent requests.

### K. How handle validation errors?

Return `400` or `422` with a consistent error body containing field errors.

### L. How secure APIs?

Use HTTPS, authentication, server-side authorization, validation, rate limits, safe CORS, and avoid leaking sensitive data.

### M. Webhook vs polling?

Polling repeatedly asks for updates. Webhooks send events to your API when something happens.

## 42. Common Mistakes and Interview Traps

| Mistake | Better answer |
| --- | --- |
| `GET /createOrder` | Use POST for creation/actions |
| Always return `200` | Use meaningful HTTP status codes |
| Frontend-only authorization | Enforce authorization on backend |
| Unlimited list endpoints | Add pagination and max limits |
| Retry POST payments blindly | Use idempotency keys |
| Publicly cache private data | Use correct cache headers |
| Expose stack traces | Return safe errors with request ID |
| Use query params for secrets | Use headers/body and protect logs |
| Use CORS as security | CORS only controls browsers |
| Break clients without versioning | Maintain backward compatibility |

## 43. Final Rapid Revision

| Topic | One-line answer |
| --- | --- |
| REST | Resource-oriented HTTP API style |
| Resource naming | Nouns, plural collections, shallow nesting |
| Stateless | Each request stands alone |
| GET | Read; safe and idempotent |
| POST | Create/process; not idempotent by default |
| PUT | Full replace; idempotent |
| PATCH | Partial update |
| DELETE | Remove; idempotent |
| 200 | Success with body |
| 201 | Created |
| 202 | Accepted for async processing |
| 204 | Success with no body |
| 400 | Bad request |
| 401 | Not authenticated |
| 403 | Not authorized |
| 404 | Not found |
| 409 | Conflict |
| 422 | Validation semantics failed |
| 429 | Rate limited |
| AuthN vs AuthZ | Identity vs permission |
| JWT | Signed bearer token with claims |
| Access token | Short-lived API token |
| Refresh token | Gets new access token |
| Offset pagination | Simple but poor for deep/changed data |
| Cursor pagination | Better for large changing datasets |
| Idempotency | Safe retries without duplicate side effects |
| Webhook | Event callback from another system |
| ETag | Resource version for conditional requests |
| CORS | Browser cross-origin read control |

## 44. References

- MDN: HTTP request methods - https://developer.mozilla.org/en-US/docs/Web/HTTP/Reference/Methods
- MDN: Safe HTTP methods - https://developer.mozilla.org/en-US/docs/Glossary/Safe/HTTP
- MDN: HTTP response status codes - https://developer.mozilla.org/en-US/docs/Web/HTTP/Reference/Status
- MDN: 401 Unauthorized - https://developer.mozilla.org/en-US/docs/Web/HTTP/Reference/Status/401
- MDN: HTTP authentication - https://developer.mozilla.org/en-US/docs/Web/HTTP/Guides/Authentication
- MDN: Authorization header - https://developer.mozilla.org/en-US/docs/Web/HTTP/Reference/Headers/Authorization
- MDN: Content-Type header - https://developer.mozilla.org/en-US/docs/Web/HTTP/Reference/Headers/Content-Type
- MDN: Accept header - https://developer.mozilla.org/en-US/docs/Web/HTTP/Reference/Headers/Accept
- MDN: Conditional requests / ETag - https://developer.mozilla.org/en-US/docs/Web/HTTP/Guides/Conditional_requests
- MDN: CORS - https://developer.mozilla.org/en-US/docs/Web/HTTP/Guides/CORS
- RFC 9110: HTTP Semantics - https://www.rfc-editor.org/rfc/rfc9110
- Microsoft: Web API design best practices - https://learn.microsoft.com/en-us/azure/architecture/best-practices/api-design
- Google Cloud API Design Guide - https://docs.cloud.google.com/apis/design
- Google Cloud API naming conventions - https://cloud.google.com/apis/design/naming_convention
- Stripe: Idempotent requests - https://docs.stripe.com/api/idempotent_requests
- Recent interview cross-checks: env.dev REST API Best Practices 2026, recent REST API interview guides from Educative, GeeksforGeeks, and practical backend interview prep resources.
