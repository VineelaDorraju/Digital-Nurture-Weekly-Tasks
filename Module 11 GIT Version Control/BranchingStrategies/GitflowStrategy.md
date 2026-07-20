git switch -c develop

git switch -c featureCart
git commit --allow-empty -m "feat: cart setup"

git switch develop
git merge featureCart

git switch -c releaseV1
git commit --allow-empty -m "release: prepare v1"

git switch main
git merge releaseV1

git tag v1.0