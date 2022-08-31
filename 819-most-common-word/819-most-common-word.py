class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        
        counts = Counter([w for w in re.split(r'\W+', paragraph.lower()) if w not in set(banned)])
        counts[''] = -1
        return counts.most_common(1)[0][0]