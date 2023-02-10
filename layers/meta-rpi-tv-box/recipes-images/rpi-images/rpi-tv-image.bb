LICENSE = "MIT"

inherit extrausers

#mkpasswd -m sha256crypt raspberry
#PI_PASSWORD = "$5$1c4tOz4A94u02FGc$.FkuDQsGvXVjAfZTdC60ouL.3of1Pbe/bme5yqHJaD0"
#EXTRA_USERS_PARAMS = "usermod -p '${ROOT_PASSWORD}' root;"

inherit core-image

IMAGE_INSTALL += " \
                 e2fsprogs-mke2fs \
                 dosfstools \
                 packagegroup-core-ssh-openssh \
                 openssh-sftp-server \
                 openssh \
                 libstdc++ \
                 gdbserver \
                 kodi \
                 wpa-supplicant \
                 nano \
                 dhcpcd \
                 python3 \
                "

IMAGE_ROOTFS_EXTRA_SPACE:append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "" ,d)}"

