#!/bin/bash

# Color variables
red=$(tput setaf 1)
blue=$(tput setaf 4)
underline=$(tput sgr 0 1)
reset=$(tput sgr0)

function installNode {
    printf "\n${blue}Installing dependency: Node${reset}\n\n"
    curl https://raw.github.com/dvillavi/nvm/master/install.sh | sh
    . ~/nvm/nvm.sh
    nvm install 0.10.5
}

function installGem {
    printf "\n${blue}Installing dependency: $1${reset}\n\nRuby needs admin priviledges:\n"
    sudo gem install $1
}

# Check if Node is installed
nodeVersion=`which node`
if [ $nodeVersion == "" ]; then
    installNode || exit 1;
fi

# Check if Compass Susy is installed
if  ! gem spec susy > /dev/null 2>&1; then
    installGem 'susy' || exit 1;
fi

# Verbose output since it appears to hang during long downloads
npm config set loglevel info

# Check if Grunt is installed
type -P grunt &>/dev/null && echo "Grunt already installed" || sudo npm install -g grunt-cli

# Install other dependencies
npm install

# Build
env=$1 grunt $1 || exit 1;

exit 0
