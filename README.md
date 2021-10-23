# Java Automation QA 
**Pet project**
AddressBook **Front/Backend** Tests


Stack:
1. Java 17
2. Selenium
3. TestNG
4. Gradle
5. Hamcrest
6. JCommander
7. MySQL
8. Hibernate
9. Jenkins + AllureReport

**About:**

**Implemented a two-level architecture of the test suite:**
1. Сommon base class for tests
2. Implemented delegation, instead of inheritance
3. Helpers classes are implemented + common base class {BaseHelper}

**Managing the code branching process:**
1. Running tests in different browsers
2. Optimizations are implemented to speed up the tests
3. Checking and providing prerequisites in tests

**Implemented checks in the fluent style**

**Using the method of reverse checks**

**Test data generators are implemented:**
1. Test data providers have been created
2. Loading information about the test bench from a configuration file, 
with the ability to specify which configuration file should be used when performing tests

**Implemented verification of data loaded from the database**

upd:
**The launch of tests on the continuous integration server has been organized**
