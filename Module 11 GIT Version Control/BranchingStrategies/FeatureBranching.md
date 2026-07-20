git switch -c featureAuth

echo "auth logic" > auth.js
git add auth.js
git commit -m "feat: auth module"

git switch main
git merge featureAuth --no-ff