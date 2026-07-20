git init

echo "console.log('v1')" > app.js
git add app.js
git commit -m "chore: bootstrap project"

echo "console.log('v2')" > app.js
git commit -am "feat: update base logic"

git log --oneline --graph

git checkout HEAD~1

git switch -c recoveryBranch