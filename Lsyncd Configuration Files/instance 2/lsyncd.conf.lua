settings = {
logfile = "/var/log/lsyncd/lsyncd.log",
statusFile = "/var/log/lsyncd/lsyncd.status"
}

sync {
default.rsync,
source = "/var/www/html/nextcloud/data",
target = "root@149.165.170.148:/var/www/html/nextcloud/data/",
delay = 0,
exclude = { '.oc_data','new.txt' },
}

