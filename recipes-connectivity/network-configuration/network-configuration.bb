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

do_configure() {
    if [ -n "${INTERFACES_CONTENT}" ]; then
        echo ${INTERFACES_CONTENT} > ${WORKDIR}/interfaces
        bbnote "Configuring interfaces file: "
        bbnote "$(echo ${INTERFACES_CONTENT})"
    else 
        bbwarn "Using default interfaces file"
    fi
    if [ -n "${WPA_SUPPLICANT_CONF_CONTENT}" ]; then
        echo ${WPA_SUPPLICANT_CONF_CONTENT} > ${WORKDIR}/wpa_supplicant.conf
        bbnote "Configuring wpa_supplicant.conf file: "
        bbnote "$(echo ${WPA_SUPPLICANT_CONF_CONTENT})"
    else
        bbwarn "Using default wpa_supplicant.conf"
    fi
}

do_install() {
    install -d ${D}/${sysconfdir}/
    install -m 0755 ${WORKDIR}/wpa_supplicant.conf ${D}/${sysconfdir}/

    install -d ${D}/${sysconfdir}/network
    install -m 0755 ${WORKDIR}/interfaces ${D}/${sysconfdir}/network/
}
