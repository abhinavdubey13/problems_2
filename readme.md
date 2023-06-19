

# to generate SSH keys
- cd to .ssh in home dir
- run : ssh-keygen -t rsa -b 4096 -C "abhinavdubey13@gmail.com"
- enter file name : example => ad13
- copy ad13.pub to gihub SSH key section
- add 'config' file (no extension) in ~/.ssh directory & add below content
    Host github.com
    HostName github.com
    User abhinavdubey13
    IdentityFile ~/.ssh/ad13

# TREE :
- problem_2 : 
