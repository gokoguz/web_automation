# Test Strategy - QA Project

## 1. Purpose
This document defines the overall test approach for the ShopDemo e-commerce platform covering API, Web, Performance and Mobile (responsive) testing.

---

## 2. Scope

### In Scope
- Web UI automation (Selenium)
- API testing (Postman/Newman)
- Performance testing (JMeter)
- Responsive/mobile simulation testing (Playwright)

### Out of Scope
- Real payment gateway integration
- Production monitoring

---

## 3. Test Approach

### 3.1 Test Pyramid
- UI Tests: 40%
- API Tests: 40%
- Performance Tests: 20%

---

## 4. Tools
- Selenium (UI Automation)
- Postman + Newman (API Testing)
- Apache JMeter (Performance Testing)
- Playwright (Responsive Web Testing)

---

## 5. Risk-Based Testing

| Risk Level 	| Modules 						|
|------------	|--------						|
| High 			| Login, Checkout, Payment 		|
| Medium 		| Product listing, Cart 		|
| Low 			| UI elements, static pages 	|

---

## 6. Entry / Exit Criteria

### Entry
- Test environment ready
- API endpoints stable

### Exit
- Critical flows passed
- No blocker defects