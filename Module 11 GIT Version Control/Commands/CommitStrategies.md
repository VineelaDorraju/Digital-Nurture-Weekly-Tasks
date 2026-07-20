git commit --allow-empty -m "chore: initial empty commit"

echo "line1" > file.txt
git add file.txt
git commit -m "feat: add base file"

echo "line2" >> file.txt
git add file.txt
git commit --amend -m "feat: add base file with extension"

git reset --soft HEAD~1
git commit -m "refactor: reorganized commit history"