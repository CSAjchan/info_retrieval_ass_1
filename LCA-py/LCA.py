class Node:

    def __init__(self, key):
        self.key = key
        self.left = None
        self.right = None

def insert(root, key):
    if root is None:
        return Node(key)
    else:
        if root.key == key:
            return root
        elif root.key < key:
            root.right = insert(root.right, key)
        else:
            root.left = insert(root.left, key)
    return root

def findPath(root, path, k):
    if root is None:
        return False

    path.append(root.key)

    if root.key == k:
        return True

    if((root.left != None and findPath(root.left, path, k)) or 
        (root.right != None and findPath(root.right, path, k))):
        return True
        
    path.pop()
    return False

def findLCA(root, n1, n2):
    path1 = []
    path2 = []

    if(not findPath(root, path1, n1) or not findPath(root, path2, n2)):
        return -1

    i = 0

    while(i < len(path1) and i < len(path2)):
        if path1[i] != path2[i]:
            break
        i += 1
    return path1[i-1]


# Driver program to test the above functions
# Let us create the following BST
#    50
#  /     \
# 30     70
#  / \ / \
# 20 40 60 80
 
root = Node(50)
root = insert(root, 30)
root = insert(root, 20)
root = insert(root, 40)
root = insert(root, 70)
root = insert(root, 60)
root = insert(root, 80)

print("LCA(20, 40) = %d" %(findLCA(root,20,40)))
print("LCA(80, 20) = %d" %(findLCA(root,80,20)))
print("LCA(30, 80) = %d" %(findLCA(root,30,80)))
print("LCA(60, 80) = %d" %(findLCA(root,60,80)))