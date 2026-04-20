# Regression Test Suite

## 1. Purpose
Bu suite, her release sonrası kritik fonksiyonların bozulmadığını doğrular.

## 2. Selection Criteria
Test case’ler aşağıdaki kriterlere göre seçilmiştir:
- P1 kritik iş akışları
- Customer journey impact
- High-risk modules
- Frequently changed components

## 3. Coverage Areas

### Authentication
- Valid login
- Invalid login
- Logout

### Product
- Product listing
- Sorting (price/name)
- Product detail page

### Cart
- Add to cart
- Remove from cart
- Cart badge validation

### Checkout
- Successful checkout flow
- Empty field validation

### API
- POST /auth
- GET /booking
- POST /booking
- DELETE /booking

## 4. Test Cases List

| TC ID 			| Module 	| Priority 	| Reason 			 |
|------				|--------	|----------	|--------			 |
| TC-LOGIN-001 		| Login 	| P1 		| Core access 		 |
| TC-CART-002 		| Cart 		| P1 		| Revenue impact	 |
| TC-API-001 		| Auth API 	| P1 		| Token dependency	 |
| TC-CHECKOUT-003 	| Checkout 	| P1 		| Business critical	 |

## 5. Execution Frequency
- Every commit → smoke subset
- Every release → full regression
- Nightly → API regression

## 6. Exit Criteria
- ≥ 95% pass rate
- 0 blocker/critical bugs