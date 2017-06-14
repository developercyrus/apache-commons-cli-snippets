### sample result
```
java -cp .;bar-1.0.jar foo.bar.cli.Cli --help
```
```
usage: foo.bar.cli.Cli
 -d,--day <arg>     the day value that you want to extract figures, e.g.
                    today, this is -d=0; yesterday, this is -d=-1.
 -h,--help          show help.
 -m,--month <arg>   the month value that you want to extract figures, e.g.
                    current month, this is -m=0; last month, this is
                    -m=-1.

```
```
java -cp .;bar-1.0.jar foo.bar.cli.Cli --month=-2
```
```
today         = 2017-06-14
start date    = 2017-04-01
end ate       = 2017-05-01
```
```
java -cp .;bar-1.0.jar foo.bar.cli.Cli -d=8
```
```
today         = 2017-06-14
required date = 2017-06-22
```