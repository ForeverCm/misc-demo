<?php
$command = "ls /tmp/test"; //ls是linux下的查目录，文件的命令
exec($command,$array); //执行命令
print_r($array);
?>