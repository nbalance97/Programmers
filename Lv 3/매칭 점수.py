import re

def get_links(page, word, idx, site_index, site_score, site_link_count, site_linked):
    page = page.lower()
    
    # 자기 사이트 가져오는 파트
    pattern = r'<meta property="og:url" content=".+"/>'
    temp = re.findall(pattern, page)
    mysite = temp[0][len('<meta property="og:url" content="'):-3]
    
    # 딕셔너리 초기화
    site_score[mysite] = 0
    site_link_count[mysite] = 0
    site_index[mysite] = idx
    if site_linked.get(mysite) == None:
        site_linked[mysite] = []
    
    # 링크한 사이트들에 자기가 링크중이라고 표시
    pattern = r'<a href="[^"]*">'
    temp = re.findall(pattern, page)
    for t in temp:
        site_link_count[mysite] += 1
        site = t[9:-2]
        if site_linked.get(site) == None:
            site_linked[site] = [mysite]
        else:
            site_linked[site].append(mysite)
    
    # 기본점수 구함
    pattern = r'[^a-z]' # 알파벳이 아닌 문자로 split 해주어야 함.
    temp = re.split(pattern, page)
    for t in temp:
        if t == word.lower():
            site_score[mysite] += 1

    return temp
    

def solution(word, pages):
    answer = 0
    max_score = -1
    site_score = dict() # 기본점수
    site_link_count = dict() # 링크 카운팅
    site_linked = dict() # 자기를 링크하고있는 사이트들
    site_index = dict() # 사이트의 인덱스
    
    for idx, page in enumerate(pages):
        get_links(page, word, idx, site_index, site_score, site_link_count, site_linked)

    for site in site_score.keys():
        linked_score = 0
        for linked_site in site_linked[site]: # 자기를 링크한 사이트들
            linked_score += (site_score[linked_site] / site_link_count[linked_site])

        total_score = site_score[site] + linked_score
        
        # 전체 점수가 최댓값이라면 갱신
        if total_score > max_score:
            max_score = total_score
            answer = site_index[site]
        elif total_score == max_score:
            answer = min(answer, site_index[site])

    return answer
