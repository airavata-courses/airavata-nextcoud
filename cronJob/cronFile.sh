#! /bin/bash 
#Script to sync the files into the two of the file servers and 
#trigger the file synchronization between the two of the nextcloud
#instances using the rsync
#echo "Hello World!"
#rsync -zap /var/www/html/nextcloud/data/* root@129.114.104.39:/var/www/html/nextcloud/data/
#rsync -aqr /var/www/html/nextcloud/data/* root@129.114.104.39:/var/www/html/nextcloud/data/ --delete
#sleep 5
#rsync -zap /var/www/html/nextcloud/data/* root@129.114.104.39:/var/www/html/nextcloud/data/
#sleep 1 
#rsync -aqr /var/www/html/nextcloud/data/* root@129.114.104.39:/var/www/html/nextcloud/data/ --delete

cd /var/www/html/nextcloud
a = 0
b = 120
while [ $a -lt $b ] 
do
	#sudo -u www-data php occ files:scan --all -v
	sleep 1
	((a=a+1))
done
