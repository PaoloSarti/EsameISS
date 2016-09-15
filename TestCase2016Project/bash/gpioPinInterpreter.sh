echo "$1" > /sys/class/gpio/unexport #
echo "$1" > /sys/class/gpio/export #
cd /sys/class/gpio/gpio"$1" #

echo out > direction #

while read ONOFF
do
	echo $ONOFF > value #
done