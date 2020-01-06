SUMMARY = "Setting up network configuration"
DESCRIPTION = "Copy wpa_supplicant.conf and interfaces file to the appropriate location"
AUTHOR = "Florian Vogel <flovo89@hotmail.com>"
HOMEPAGE = "https://github.com/flovo89"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${GPLv2_LICENSE_PATH};md5=${GPLv2_LICENSE_CHECKSUM}"

BBCLASSEXTEND = "nativesdk"

SRC_URI = "\
    file://wpa_supplicant.conf \
    file://interfaces \
    "

do_install() {
    install -d ${D}/${sysconfdir}/
    install -m 0755 ${WORKDIR}/wpa_supplicant.conf ${D}/${sysconfdir}/

    install -d ${D}/${sysconfdir}/network
    install -m 0755 ${WORKDIR}/interfaces ${D}/${sysconfdir}/network/
}
