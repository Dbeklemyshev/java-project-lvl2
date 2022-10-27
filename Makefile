clean:
	app/gradlew clean
build: ./gradlew clean build
install:
	app/gradlew clean install
run-dist:
	app/build/install/app/bin/app
run:
	app/gradlew run
lint:
	app/gradlew checkstyleMain checkstyleTest
check-updates:
	app/gradlew useLatestVersions
test:
	app/gradlew test
report:
	app/gradlew jacocoTestReport

.PHONY: build
