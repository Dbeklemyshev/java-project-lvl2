clean:
	./gradlew clean
build: ../gradlew clean build
install:
	./gradlew clean install
run-dist:
	app/build/install/app/bin/app
run:
	./gradlew run
lint:
	./gradlew checkstyleMain checkstyleTest
check-updates:
	./gradlew useLatestVersions
test:
	./gradlew test
report:
	./gradlew jacocoTestReport

.PHONY: build