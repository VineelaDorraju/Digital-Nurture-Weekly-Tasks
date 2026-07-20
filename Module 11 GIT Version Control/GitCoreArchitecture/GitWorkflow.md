git init

echo "draft" > notes.txt
git status

git add notes.txt
git status

git commit -m "chore: move to repository"

echo "updated draft" >> notes.txt

git diff
git add notes.txt

git diff --cached
git commit -m "feat: refined notes"