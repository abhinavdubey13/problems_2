

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
- https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
- https://leetcode.com/problems/check-completeness-of-a-binary-tree/
- https://leetcode.com/problems/smallest-string-starting-from-leaf/
- https://leetcode.com/problems/binary-tree-coloring-game/
- https://leetcode.com/problems/increasing-order-search-tree/
- https://leetcode.com/problems/path-sum-iii/description/
- https://leetcode.com/problems/delete-node-in-a-bst/
- iterative post order traversal





