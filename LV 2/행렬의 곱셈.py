import numpy as np
 
def solution(arr1, arr2):
    a1 = np.matmul(np.array(arr1),np.array(arr2))
    answer = a1.tolist()
    return answer
