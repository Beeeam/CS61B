IntList和SLList的差别
IntList是对节点直接操作，因此可以用this.rest进行recursion（被称为naked，no-clothing）
SLList是通过操作first来改变IntNode，不能用first.next进行recursion，因此需要private size将它解封。SLList可以储存cache--size。
