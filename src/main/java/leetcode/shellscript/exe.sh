#!/usr/bin/env bash
#
# While Loop Practice 1

# Main body of the shell script starts here.
while true
do
    read -p "
             1. Show disk usage.
             2. Show system uptime.
             3. Show the users logged into the system.
             What would you like to do? (Enter q to quit.) " CHOICE
    case $CHOICE in
        1)
            df -h
            echo
            ;;
        2)
            uptime
            echo
            ;;
        3)
            who
            echo
            ;;
        q)
            echo "Goodbye!"
            exit 0
            ;;
        *)
            echo "Invalid Option."
            ;;
    esac
done

# Exit with an explicit exit status.
exit 0
