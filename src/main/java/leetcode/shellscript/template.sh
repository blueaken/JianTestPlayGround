#!/usr/bin/env bash
#
# <Replace with the description and/or purpose of this shell script.>

GLOBAL_VAR1="one"
GLOBAL_VAR2="two"

function function_one() {
  local LOCAL_VAR1="one"
  # <Replace with function code.>
}

# Main body of the shell script starts here.
#
# <Replace with the main commands of your shell script.>

# Exit with an explicit exit status.
exit 0


#Also check the following best practice
#ref: http://kvz.io/blog/2013/11/21/bash-best-practices/
#
##!/usr/bin/env bash
## Bash3 Boilerplate. Copyright (c) 2014, kvz.io
#
#set -o errexit
#set -o pipefail
#set -o nounset
## set -o xtrace
#
## Set magic variables for current file & dir
#__dir="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
#__file="${__dir}/$(basename "${BASH_SOURCE[0]}")"
#__base="$(basename ${__file} .sh)"
#__root="$(cd "$(dirname "${__dir}")" && pwd)" # <-- change this as it depends on your app
#
#arg1="${1:-}"
#
