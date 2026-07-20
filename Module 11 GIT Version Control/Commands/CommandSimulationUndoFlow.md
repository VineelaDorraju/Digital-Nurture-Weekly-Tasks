echo "mistake" > bug.txt
git add bug.txt
git commit -m "feat: wrong change"

git revert HEAD

git reset --hard HEAD~1