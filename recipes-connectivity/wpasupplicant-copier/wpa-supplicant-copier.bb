SUMMARY = "Setting up wifi configuration"
DESCRIPTION = "Copy wpa_supplicant.conf to the appropriate location"
AUTHOR = "Florian Vogel <flovo89@hotmail.com>"
HOMEPAGE = "https://github.com/flovo89"
LICENSE = "GPLv2"

BBCLASSEXTEND = "nativesdk"

SRC_URI = "\
    file://wpa_supplicant.conf \
    "

do_install() {
    install -d ${D}/${sysconfdir}/
    install -m 0755 ${WORKDIR}/wpa_supplicant.conf ${D}/${sysconfdir}/
}
