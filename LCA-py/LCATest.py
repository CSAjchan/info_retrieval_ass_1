import unittest
from LCA import *

class LCATest(unittest.TestCase):
   
    def testOneElementInLCA(self):
        root = Node(50)
        self.assertEqual(findLCA(root,50,50),50)
        self.assertEqual(findLCA(root,0,50),-1)
        self.assertEqual(findLCA(root,0,100),-1)

    def testTwoElementInLCA(self):
        root = Node(50)
        root = insert(root, 30)
        root = insert(root, 20)
        self.assertEqual(findLCA(root,30,50),50)
        self.assertEqual(findLCA(root,50,50),50)
        self.assertEqual(findLCA(root,30,30),30)
        self.assertEqual(findLCA(root,0,50),-1)
        self.assertEqual(findLCA(root,0,100),-1)

    def testLCA(self):
        root = Node(50)
        root = insert(root, 30)
        root = insert(root, 20)
        root = insert(root, 15)
        root = insert(root, 25)
        root = insert(root, 40)
        root = insert(root, 70)
        root = insert(root, 60)
        root = insert(root, 55)
        root = insert(root, 80)
        root = insert(root, 90)
        #if the numbers are in the tree
        self.assertEqual(findLCA(root,20,40),30)
        self.assertEqual(findLCA(root,80,20),50)
        self.assertEqual(findLCA(root,30,80),50)
        self.assertEqual(findLCA(root,60,80),70)
        self.assertEqual(findLCA(root,15,40),30)
        self.assertEqual(findLCA(root,55,90),70)
        #if the numbers come one after another in the tree
        self.assertEqual(findLCA(root,80,90),80)
        self.assertEqual(findLCA(root,30,50),50)
        self.assertEqual(findLCA(root,30,25),30)
        #if one or two of the numbers are not in the tree
        self.assertEqual(findLCA(root,15,100),-1)
        self.assertEqual(findLCA(root,35,70),-1)
        self.assertEqual(findLCA(root,5,100),-1)
        #if the same number is used twice
        self.assertEqual(findLCA(root,50,50),50)
        #if the same number is used twice which is not in the tree
        self.assertEqual(findLCA(root,0,0),-1)

if __name__ == '__main__':
    unittest.main()