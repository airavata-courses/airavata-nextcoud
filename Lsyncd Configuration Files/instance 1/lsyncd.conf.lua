settings = {
logfile = "/var/log/lsyncd/lsyncd.log",
statusFile = "/var/log/lsyncd/lsyncd.status"
}

sync {
default.rsync,
source = "/var/www/html/nextcloud/data",
target = "root@129.114.104.39:/var/www/html/nextcloud/data/",
delay = 0,
exclude = { '.oc_data','new.txt' },
}
