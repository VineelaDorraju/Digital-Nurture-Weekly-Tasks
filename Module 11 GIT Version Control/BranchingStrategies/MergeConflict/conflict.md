git switch -c featureA

echo "logic A" > engine.js
git commit -am "feat: logic A"

git switch main
git switch -c featureB

echo "logic B" > engine.js
git commit -am "feat: logic B"

git switch main
git merge featureA
git merge featureB