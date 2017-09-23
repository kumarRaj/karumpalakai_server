#!/usr/bin/env bash -x

sudo yum install -y git

sudo yum install -y gcc-c++ make
curl -sL https://rpm.nodesource.com/setup_6.x | sudo -E bash -
sudo yum install -y nodejs


git clone https://github.com/kumarRaj/karumpalakai_server.git
git clone https://github.com/kumarRaj/karumpalakai_client.git


# https://www.mkyong.com/java/how-to-install-oracle-jdk-8-on-centos/
wget --header "Cookie: oraclelicense=accept-securebackup-cookie" http://download.oracle.com/otn-pub/java/jdk/8u144-b01/090f390dda5b47b9b721c7dfaa008135/jdk-8u144-linux-x64.rpm
sudo yum localinstall -y jdk-8u144-linux-x64.rpm

export JAVA_HOME=/usr/java/jdk1.8.0_144/