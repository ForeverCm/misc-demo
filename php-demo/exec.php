<?php
// exec('/Users/chenmeng08/t3jar/mp4DecryptMac/t3javaVM/temurin-11.jdk/Contents/Home/bin/java -jar /Users/chenmeng08/t3jar/mp4DecryptMac/bars-sdk-0.3.2.jar -f /home/chenmeng08/t3/t3jar/157627879086026949_1676885572493.mp4 -i /3a20f734a8824d1b916808ac8be5c618/157627704088229700/157627879086026949/157627879086026949_1676885572493.mp4 -t 2426e6d67d238e10438904e624317202 -o /home/work/t3/t3jar/cmcm.mp4 2>&1', $array);
// var_dump($array);




class AesCTR
{
    public static function encrypt($str, $key, $iv)
    {
        return openssl_encrypt($str, 'AES-256-CTR', $key, OPENSSL_ZERO_PADDING, $iv);
    }

    public static function decrypt($encryptedStr, $key, $iv)
    {
        return openssl_decrypt($encryptedStr, 'AES-256-CTR', $key, OPENSSL_ZERO_PADDING, $iv);
    }
}



// GYMOFemPkuv8zCNneHwOsTBzEbNDjizZ
// Z6B3O2zFRN2TRcZMERGqxQLwv1FgziRn
$plainText = 'long_long_ago';
$exampleEncryptString = 'dauilOB05xd3DXzAwsRtKhMI4EQyCwTYjOpBqHsdcrYILrF9jqtZGTFPts9A0KymqR7u5v0o+rGtMTeq+qEztAZdu+aoTQiXMuJiz4+H6C4l7ZOiwfEsd0tlQYb8kC/gZhsNxmVRqaV9YFig/rXNYpFLO8X9xB9CTkjpLFuWSBlQi8m8';



// 32 位
$key = 'YlYOUjn1X3NRmj5BlY3NcYOAKscyKAJU';

// 16 位
$iv = 'BDAii1rTV1zivPjl';


$aaa = '{"cuid":"951113EB266019542620","reqTime":1679539223,"callTime":1679539223,"seqNo":"4a90bd1910c87edd9038a03aafa0b7ce", "extends":"[]"}';
echo AesCTR::encrypt($aaa, $key, $iv);

echo "\r\n";

echo AesCTR::decrypt($exampleEncryptString, $key, $iv);


if (strpos('aaaaabcd','aaa') === 0) {
    echo 'aaaa';
}else {
    echo 'bbbbb';
}




?>
