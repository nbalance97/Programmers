import sys

sys.setrecursionlimit(10**6)

class tree:
    def __init__(self, element):
        self.left = None
        self.right = None
        self.element = element

def tree_push(root, node):
    # X좌표 비교
    if root == None:
        root = node
    
    if root.element[0] > node.element[0]:
        if root.left == None:
            root.left = node
        else:
            tree_push(root.left, node)

    elif root.element[0] < node.element[0]:
        if root.right == None:
            root.right = node
        else:
            tree_push(root.right, node)

def preorder(node, answer):
    if node == None:
        return
    answer.append(node.element[2])
    preorder(node.left, answer)
    preorder(node.right, answer)

def postorder(node, answer):
    if node == None:
        return
    postorder(node.left, answer)
    postorder(node.right, answer)
    answer.append(node.element[2])

    
def solution(nodeinfo):
    answer = [[], []]
    for idx, node in enumerate(nodeinfo):
        node.append(idx+1)
    nodeinfo.sort(key=lambda x:(-x[1], x[0]))
    
    root = tree(nodeinfo[0])
    for i in range(1, len(nodeinfo)):
        temp = tree(nodeinfo[i])
        tree_push(root, temp)

    preorder(root, answer[0])
    postorder(root, answer[1])
    return answer
