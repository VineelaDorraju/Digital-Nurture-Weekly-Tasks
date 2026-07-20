git clone https://github.com/yourfork/repo.git

cd repo
git remote add upstream https://github.com/original/repo.git

git fetch upstream
git merge upstream/main