# 🎭 SauceDemo Playwright Automation Framework

A robust and maintainable **Web UI Automation Testing Framework** built using **Java, Playwright, Gradle, and TestNG**.

This framework is designed using the **Page Object Model (POM)** architecture with reusable **Page Objects, UI Components, Utilities, Enums, Authentication Support, and TestNG Test Suites**.

The framework automates major user journeys of the **SauceDemo** web application, including login, products, cart, checkout, payment, order completion, logout, and footer validations.

---

## 🛠️ Technology Stack

| Technology            | Purpose                       |
| --------------------- | ----------------------------- |
| **Java**              | Programming Language          |
| **Playwright**        | Web UI Automation             |
| **Gradle**            | Build & Dependency Management |
| **TestNG**            | Test Execution & Assertions   |
| **IntelliJ IDEA**     | Development IDE               |
| **Git / GitLab**      | Version Control               |
| **Page Object Model** | Framework Architecture        |

---

## ✨ Key Features

* ✅ Java + Playwright automation
* ✅ Page Object Model (POM)
* ✅ Reusable UI Components
* ✅ Base Page Architecture
* ✅ Base Test Architecture
* ✅ Authenticated Test Support
* ✅ TestNG Test Execution
* ✅ Smoke Test Suite
* ✅ Regression Test Suite
* ✅ Gradle Build Management
* ✅ Configurable Browser Execution
* ✅ Headed / Headless Execution
* ✅ Reusable Credentials Management
* ✅ Device-based Configuration
* ✅ Cross-browser support
* ✅ HTML Test Reports
* ✅ CI/CD Ready

---

# 📂 Project Structure

```text
saucedemo-playwright-automation
│
├── src
│   │
│   ├── main
│   │   │
│   │   ├── java
│   │   │   └── com.saucedemo.web
│   │   │       │
│   │   │       ├── components
│   │   │       │   ├── BaseComponent
│   │   │       │   ├── BaseInputElement
│   │   │       │   ├── BaseLargeInputElement
│   │   │       │   ├── Cart
│   │   │       │   ├── ErrorMessage
│   │   │       │   ├── Footer
│   │   │       │   ├── PaymentConfirmationModal
│   │   │       │   ├── PaymentInfoCard
│   │   │       │   ├── ProductInfo
│   │   │       │   ├── RequiredInputElement
│   │   │       │   ├── SearchFormNavigationBar
│   │   │       │   ├── SelectElement
│   │   │       │   ├── Slider
│   │   │       │   ├── TextInputElement
│   │   │       │   └── Topbar
│   │   │       │
│   │   │       ├── enums
│   │   │       │   ├── SortOption
│   │   │       │   └── PaymentMethod
│   │   │       │
│   │   │       ├── pages
│   │   │       │   ├── BasePage
│   │   │       │   ├── CartPage
│   │   │       │   ├── CheckoutPage
│   │   │       │   ├── HomePage
│   │   │       │   ├── LoginPage
│   │   │       │   ├── LogoutPage
│   │   │       │   ├── OrderCompletionPage
│   │   │       │   ├── PaymentSandboxPage
│   │   │       │   └── ProductPage
│   │   │       │
│   │   │       ├── utils
│   │   │       │   ├── Credential
│   │   │       │   ├── CredentialStore
│   │   │       │   ├── Device
│   │   │       │   ├── FileUtil
│   │   │       │   └── TargetDevice
│   │   │       │
│   │   │       └── PlaywrightConfig
│   │   │
│   │   └── resources
│   │       └── config.properties
│   │
│   └── test
│       │
│       ├── java
│       │   └── com.saucedemo.web
│       │       ├── BaseTest
│       │       ├── BaseAuthenticatedTest
│       │       ├── LoginTest
│       │       ├── LogoutTest
│       │       ├── HomeTest
│       │       ├── ProductTest
│       │       ├── CartTest
│       │       ├── CheckoutTest
│       │       ├── FooterTest
│       │       └── OrderCompletionTest
│       │
│       └── resources
│           ├── credentials.properties
│           ├── smoke-suite.xml
│           └── regression-suite.xml
│
├── .gitignore
├── build.gradle
├── settings.gradle
├── gradlew
├── gradlew.bat
└── README.md
```

---

# 🏗️ Framework Architecture

The framework follows the **Page Object Model (POM)** design pattern.

```text
                    TestNG Test Classes
                           │
                           ▼
             BaseTest / BaseAuthenticatedTest
                           │
                           ▼
                      Page Objects
                           │
              ┌────────────┴────────────┐
              ▼                         ▼
        UI Components               Utilities
              │                         │
              └────────────┬────────────┘
                           ▼
                       Playwright
                           │
                           ▼
                    SauceDemo Web
```

---

# 📦 Components

The `components` package contains reusable UI components.

### BaseComponent

Base class for reusable UI components.

### Input Components

* `BaseInputElement`
* `BaseLargeInputElement`
* `RequiredInputElement`
* `TextInputElement`

These provide reusable behavior for different input fields.

### UI Components

* `Cart`
* `ErrorMessage`
* `Footer`
* `Topbar`
* `Slider`
* `SelectElement`
* `ProductInfo`
* `SearchFormNavigationBar`

### Payment Components

* `PaymentInfoCard`
* `PaymentConfirmationModal`

These components handle reusable payment-related UI elements.

---

# 📄 Page Objects

The `pages` package contains Page Object classes.

### BasePage

Provides common functionality shared by different pages.

### LoginPage

Handles login-related actions and validations.

### HomePage

Handles the main application/home page.

### ProductPage

Handles product listing and product-related actions.

### CartPage

Handles shopping cart functionality.

### CheckoutPage

Handles checkout information and order processing.

### PaymentSandboxPage

Handles payment sandbox related functionality.

### OrderCompletionPage

Handles order completion page validations.

### LogoutPage

Handles logout functionality.

---

# 🔢 Enums

The `enums` package contains predefined values used throughout the framework.

### SortOption

Stores supported product sorting options such as name and price sorting.

### PaymentMethod

Stores supported payment methods.

Using enums helps reduce hard-coded values and improves code readability.

---

# 🔧 Utilities

The `utils` package contains reusable helper classes.

### Credential

Represents user credential information.

### CredentialStore

Manages and provides stored credentials for test execution.

### Device

Represents device-related configuration.

### TargetDevice

Defines target device information for test execution.

### FileUtil

Provides reusable file-related utility operations.

---

# ⚙️ Playwright Configuration

`PlaywrightConfig` manages Playwright-related configuration and browser setup.

The framework can be configured for different execution modes and browsers.

Example configuration:

```properties
browserType=chrome
headless=false
baseUrl=https://www.saucedemo.com/
slowMo=1000
```

### Configuration

| Property      | Description                           |
| ------------- | ------------------------------------- |
| `browserType` | Browser used for execution            |
| `headless`    | Runs browser with or without UI       |
| `baseUrl`     | Application base URL                  |
| `slowMo`      | Adds delay between Playwright actions |

---

# 🔐 Authentication Support

The framework includes:

```text
BaseTest
BaseAuthenticatedTest
```

`BaseTest` provides the common test setup and teardown.

`BaseAuthenticatedTest` is used when a test requires an already authenticated session.

This allows authenticated tests to reuse the session instead of performing login repeatedly.

```text
Login
   ↓
Authentication / Session
   ↓
BaseAuthenticatedTest
   ↓
Execute Test
```

---

# 🧪 Automated Test Coverage

The framework covers the major SauceDemo user journeys.

## 🔐 Login

`LoginTest`

* Valid login
* Invalid login
* Login validation
* Error message validation

---

## 🚪 Logout

`LogoutTest`

* Logout functionality
* Logout page validation
* User session validation

---

## 🏠 Home

`HomeTest`

* Home page validation
* Product visibility
* Page elements validation

---

## 🛍️ Products

`ProductTest`

* Product page validation
* Product visibility
* Product selection
* Product information validation

---

## 🛒 Cart

`CartTest`

* Add product to cart
* Remove product from cart
* Cart item validation
* Cart functionality

---

## 💳 Checkout

`CheckoutTest`

* Checkout page validation
* Customer information
* Required field validation
* Checkout information
* Order summary

---

## 💰 Payment

Payment-related functionality is handled through:

* `PaymentSandboxPage`
* `PaymentInfoCard`
* `PaymentConfirmationModal`
* `PaymentMethod`

---

## 🎉 Order Completion

`OrderCompletionTest`

* Order completion validation
* Success message validation
* Completion page validation
* Completion URL validation

---

## 🦶 Footer

`FooterTest`

* Footer visibility
* Footer elements
* Social media icons
* External URL validation

---

# 🧪 TestNG Suites

The framework contains separate TestNG suites for different testing purposes.

## 🚀 Smoke Test Suite

```text
smoke-suite.xml
```

Used to execute critical and high-priority test scenarios.

---

## 🔄 Regression Test Suite

```text
regression-suite.xml
```

Used to execute a broader set of automated test scenarios after application changes.

---

# 📋 Prerequisites

Before running this project, install:

* Java JDK 17 or higher
* IntelliJ IDEA
* Git
* Internet connection

### Check Java

```bash
java -version
```

### Check Git

```bash
git --version
```

---

# 🚀 Getting Started

## 1. Clone the Repository

```bash
git clone <repository-url>
```

## 2. Navigate to the Project

```bash
cd saucedemo-playwright-automation
```

## 3. Install Playwright Browsers

### Windows

```bash
gradlew.bat playwrightInstall
```

### Linux / macOS

```bash
./gradlew playwrightInstall
```

---

# ▶️ Running Tests

## Run All Tests

### Windows

```bash
gradlew.bat test
```

### Linux / macOS

```bash
./gradlew test
```

---

## Run Smoke Suite

```bash
gradlew.bat test -DsuiteXmlFile=smoke-suite.xml
```

---

## Run Regression Suite

```bash
gradlew.bat test -DsuiteXmlFile=regression-suite.xml
```

---

# 🌐 Browser Support

Playwright supports multiple browsers.

The framework can be configured to run tests on:

* 🌐 Chrome
* 🌐 Chromium
* 🦊 Firefox
* 🧭 WebKit

---

# 📊 Test Reports

After test execution, Gradle generates an HTML test report.

Report location:

```text
build/reports/tests/test/index.html
```

The report contains:

* ✅ Passed Tests
* ❌ Failed Tests
* ⏭️ Skipped Tests
* ⏱️ Execution Details

Open the `index.html` file in a browser to view the report.

---

# 🔄 CI/CD

The framework is ready for CI/CD integration.

A typical pipeline can follow:

```text
Checkout Code
      ↓
Setup Java
      ↓
Setup Gradle
      ↓
Install Playwright Browsers
      ↓
Execute TestNG Tests
      ↓
Generate Test Report
      ↓
Publish Test Results
```

The framework is integrated with **GitHub Actions for CI/CD** and automated test execution.

---

# 🔧 Git Workflow

### Check Current Status

```bash
git status
```

### Pull Latest Code

```bash
git pull
```

### Add Changes

```bash
git add .
```

### Commit Changes

```bash
git commit -m "Updated automation tests"
```

### Push Changes

```bash
git push
```

---

# 🔄 Development Workflow

```text
        Pull Latest Code
                ↓
       Develop / Update Test
                ↓
         Run Tests Locally
                ↓
        Analyze Test Results
                ↓
          Fix Test Failures
                ↓
             git add
                ↓
           git commit
                ↓
             git push
```

---

# 🎯 Framework Objectives

The main objectives of this framework are:

* Reduce manual testing effort
* Increase automation coverage
* Improve test execution speed
* Reduce code duplication
* Create reusable components
* Maintain clean and readable automation code
* Simplify test maintenance
* Support scalable automation
* Support multiple browsers
* Enable CI/CD execution

---

# 🔮 Future Enhancements

Potential future improvements include:

* [ ] Parallel test execution
* [ ] Screenshot capture on failure
* [ ] Video recording for failed tests
* [ ] Advanced test reporting
* [ ] Retry mechanism
* [ ] Cross-browser parallel execution
* [ ] Environment-based configuration
* [ ] API automation integration

---

# 👨‍💻 Project Information

**Project:** SauceDemo Playwright Automation

**Automation Framework:** Playwright

**Language:** Java

**Build Tool:** Gradle

**Test Framework:** TestNG

**Architecture:** Page Object Model (POM)

---

## ❤️ Built For

**Software Quality Assurance & Test Automation**

Built with **Java + Playwright + Gradle + TestNG**.
