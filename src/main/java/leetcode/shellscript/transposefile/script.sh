#!/usr/bin/env bash

awk '{
    max_nf = NF
    max_nr = NR
    for (x = 1; x <= NF; x++) {
        for (y = 1; y <= NR; y++) {
            a[x, y] = $x
            printf("%s", $x)
            printf(" ")
        }
    }
}
' file.txt


#
#        printf("%s", $x)
#        printf(" ")
#        printf("%s", x)
#        printf(" ")
#        printf("%s", NR)
#        printf(" ")
#        printf("%s", NF)
#
#        printf("\n")