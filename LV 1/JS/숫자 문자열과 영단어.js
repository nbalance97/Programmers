function replaceAll(s, a, b) {
    while (true) {
        let t = s.replace(a, b);
        if (t === s) {
            return t
        } else {
            s = t
        }
    }
}

function solution(s) {
    var answer = s.toLowerCase();
    let match = {
        "zero": 0, "one": 1, "two": 2, "three": 3, "four": 4,
        "five": 5, "six": 6, "seven": 7, "eight": 8, "nine": 9
    }
    
    for (let key in match) {
        answer = replaceAll(answer, key, match[key]);
    }
    
    return parseInt(answer, 10);
}
