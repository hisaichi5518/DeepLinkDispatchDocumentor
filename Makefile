bumpMajor:
	./gradlew bumpMajor genReadMe commitToGit genTag

bumpMinor:
	./gradlew bumpMinor genReadMe commitToGit genTag

bumpPatch:
	./gradlew bumpPatch genReadMe commitToGit genTag
