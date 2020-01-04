DEPENDS += " \
    wpa-supplicant-copier \
    "

INITSCRIPT_PARAMS = "start 05 2 3 4 5 . stop 80 0 6 1 ."