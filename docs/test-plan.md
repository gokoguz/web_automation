# Test Plan - ShopDemo QA Project

## 1. Introduction
Bu doküman ShopDemo e-ticaret platformu için test yaklaşımını tanımlar.

## 2. Scope

### In Scope
- Web UI testing (SauceDemo)
- API testing (Restful Booker)
- Performance testing (JMeter)
- Responsive/Mobile testing

### Out of Scope
- Production monitoring
- Security penetration testing (deep)

## 3. Test Types
- Functional Testing
- Regression Testing
- API Testing
- Performance Testing
- Cross-browser testing

## 4. Test Approach
- Black-box testing
- Risk-based testing
- API contract validation
- UI automation (Playwright POM)

## 5. Test Environment
- Chrome latest
- Firefox latest
- Node.js 18+
- JMeter 5+
- Postman/Newman

## 6. Entry Criteria
- Test environment ready
- API endpoints active
- Build deployed

## 7. Exit Criteria
- Critical bugs = 0
- All P1 test cases passed
- Regression suite %95+ pass rate

## 8. Tools
- Playwright
- Postman + Newman
- JMeter
- GitHub Actions

## 9. Risks
- API instability
- Test data inconsistency
- flaky UI tests (timing issues)

## 10. Schedule
- Day 1–2: API + UI test design
- Day 3–4: automation
- Day 5: performance + reporting