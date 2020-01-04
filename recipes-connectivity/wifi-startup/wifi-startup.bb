SUMMARY = "Start wifi"
DESCRIPTION = "Use ifup to start wifi chip"
AUTHOR = "Florian Vogel <flovo89@hotmail.com>"
HOMEPAGE = "https://github.com/flovo89"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${GPLv2_LICENSE_PATH};md5=${GPLv2_LICENSE_CHECKSUM}"

BBCLASSEXTEND = "nativesdk"

SRC_URI = "\
    file://wifi-up \
    "

inherit update-rc.d

INITSCRIPT_NAME_${PN}-wifi-up = "wifi-up"
INITSCRIPT_PARAMS_${PN}-wifi-up = "start 03 1 2 3 4 5 ."
INITSCRIPT_PACKAGES = "${PN}-wifi-up"
PACKAGES =+ "${PN}-wifi-up"
FILES_${PN}-wifi-up = "${sysconfdir}/init.d/wifi-up"
RRECOMMENDS_${PN} += "${PN}-wifi-up"

do_install() {
    install -d ${D}/${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/wifi-up ${D}/${sysconfdir}/init.d/
}
