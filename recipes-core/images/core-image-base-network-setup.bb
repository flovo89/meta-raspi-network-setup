SUMMARY = "Console-only image"
DESCRIPTION = "A console-only image that fully supports the target device hardware and adds wifi support"
AUTHOR = "Florian Vogel <flovo89@hotmail.com>"
HOMEPAGE = "https://github.com/flovo89"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${GPLv2_LICENSE_PATH};md5=${GPLv2_LICENSE_CHECKSUM}"

IMAGE_FEATURES += " \
    splash \
    debug-tweaks \
    ssh-server-dropbear \
    "

inherit core-image

DISTRO_FEATURES:append = " \
    bluez5 \
    bluetooth \
    wifi \
    "

IMAGE_INSTALL:append = " \
    linux-firmware-bcm43430 \
    bluez5 \
    bridge-utils \
    hostapd \
    iptables \
    wpa-supplicant \
    network-configuration \
    "
