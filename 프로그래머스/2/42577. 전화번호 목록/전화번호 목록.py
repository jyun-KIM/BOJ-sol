def solution(phone_book):
    answer = True
    d_phone = {phone: True for phone in phone_book}
    for phone in phone_book:
        check=''
        for c in phone:
            check+=c
            if check in d_phone and  check!=phone:
                answer=False
    return answer