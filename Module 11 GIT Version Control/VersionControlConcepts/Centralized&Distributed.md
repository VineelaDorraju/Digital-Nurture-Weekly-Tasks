git clone https://example.com/repo.git centralizedRepo

cd centralizedRepo
git pull origin main

git clone --bare https://example.com/repo.git distributedRepo.git

cd distributedRepo.git
git branch
git show-ref

git clone distributedRepo.git localCopy
cd localCopy

echo "local change" >> file.txt
git commit -am "feat: local commit without server"