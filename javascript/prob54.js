//Parse file
var fs = require("fs");
var content = fs.readFileSync("poker.txt", "utf8")
var array = content.split("\n");
var playerOneHands = [];
var playerTwoHands = [];
var oneWins = 0;
var twoWins = 0;
var tieCount = 0;

for(var i=0; i<array.length; i++){
	var cards = array[i].split(" ");
	playerOneHands.push([cards[0], cards[1], cards[2], cards[3], cards[4]]);
	playerTwoHands.push([cards[5], cards[6], cards[7], cards[8], cards[9]]);
	var hand1 = [cards[0], cards[1], cards[2], cards[3], cards[4]];
	var hand2 = [cards[5], cards[6], cards[7], cards[8], cards[9]];
	var a = false;
	var b = false;
	var winner = findWinner(hand1, hand2);
	if(winner == 1){
		oneWins++;
		a=true;
	}
	else if(winner == 2){
		twoWins++;
		b=true;
	}
	// console.log(hand1 + " - " + score(hand1).score + " - " + score(hand1).desc + (a ? " - Winner" : " "));
	// console.log(hand2 + " - " + score(hand2).score + " - " + score(hand2).desc + (b ? " - Winner" : " "));
	// console.log(hand1 + " - " + (a ? " - Winner" : " "));
	// console.log(score(hand1));
	// console.log(hand2 + " - " + (b ? " - Winner" : " "));
	// console.log(score(hand2))
	// console.log("-----------");
	// console.log("-----------");
	// console.log("-----------");
}
console.log("Player 1 wins: " + oneWins);
console.log("Player 2 wins: " + twoWins);
console.log("ties: " + tieCount)
function findWinner(h1, h2){
	var s1 = score(h1);
	var s2 = score(h2);

	if(s1.score > s2.score){
		return 1;
	}
	if(s2.score > s1.score){
		return 2;
	}
	if(s1.score == s2.score){
		
		var rankHigh1 = s1.rankHigh;
		var rankHigh2 = s2.rankHigh;

		//Check for rank highs
		for(var i=0; i<rankHigh1.length; i++){
			if(rankHigh1[i] > rankHigh2[i]){
				return 1;
			}else if(rankHigh1[i] < rankHigh2[i]){
				return 2;
			}
		}

		//Check for kickers
		var kickers1 = s1.kickers;
		var kickers2 = s2.kickers;
		for(var i=0; i<kickers1.length; i++){
			if(kickers1[i] > kickers2[i]){
				return 1;
			}
			else if(kickers1[i] < kickers2[i]){
				return 2;
			}
		}
		tieCount++;
	}
}
// console.log(playerTwoHands)

function score(hand){
	var h = parseHand(hand);
	var score = {};

	//Check for Flush
	var isFlush = isFlush_(h);
	var isStraight = isStraight_(h);
	var highCard = h.numbers[0];

	//Royal Flush
	if(isFlush && isStraight && highCard == 14){
		score['score'] = 10;
		score['desc'] = "Royal Flush";
		return score;
	}
	//Straight Flush
	else if(isFlush && isStraight){
		score['score'] = 9;
		score['rankHigh'] = h.numbers;
		score['desc'] = "Straight Flush";
		return score;
	}
	//Flush
	else if(isFlush){
		score['score'] = 6;
		score['rankHigh'] = h.numbers;
		score['desc'] = "Flush";
		return score;
	}
	//Straight
	else if(isStraight){
		score['score'] = 5;
		score['rankHigh'] = h.numbers;
		score['desc'] = "Straight";
		return score;
	}

	var numbers = h.numbers;
	//Four of a kind and full house
	if(numbers.length == 2){
		var a = numbers[0];
		var b = numbers[1];

		//Four of a kind
		if(h.hand[a].length == 4 && h.hand[b].length == 1){
			score['score'] = 8;
			score['rankHigh'] = a;
			score['kicker'] = b;
			score['desc'] = "Four of a kind";
			return score;
		}
		else if(h.hand[a].length == 1 && h.hand[b].length == 4){
			score['score'] = 8;
			score['rankHigh'] = b;
			score['kicker'] = a;
			score['desc'] = "Four of a kind";
			return score;
		}

		//Full house
		if(h.hand[a].length == 3){
			score['score'] = 7;
			score['rankHigh'] = [a,b];
			score['desc'] = "Full hosue";
			return score;
		}else{
			score['score'] = 7;
			score['rankHigh'] = [b,a];
			score['desc'] = "Full house";
			return score;
		}
	}
	//Two pairs and triple
	else if(numbers.length == 3){
		var triple = [];
		var pairs = [];
		var kickers = [];
		for(var i=0; i<numbers.length; i++){
			var n = numbers[i];
			if(h.hand[n].length == 3){
				triple.push(n);
			}
			else if(h.hand[n].length == 1){
				kickers.push(n);
			}
			else if(h.hand[n].length == 2){
				pairs.push(n);
			}
		}
		kickers.sort(function(a,b){return b-a;})
		if(triple.length ==1){
			score['score'] = 4;
			score['rankHigh'] = triple[0];
			score['kickers'] = kickers;
			score['desc'] = "Triple";
			return score;
		}
		else if(pairs.length == 2){
			score['score'] = 3;
			score['rankHigh'] = [Math.max(pairs[0], pairs[1]), Math.min(pairs[0], pairs[1])];
			score['kickers'] = kickers;
			score['desc'] = "Two pairs";
			return score;
		}
	}
	//One Pair
	else if(numbers.length == 4){
		var pair = [];
		var kickers = [];
		for(var i=0; i<numbers.length ; i++){
			var n = numbers[i];
			if(h.hand[n].length == 2){
				pair.push(n);
			}else{
				kickers.push(n);
			}
		}
		kickers.sort(function(a,b){return b-a;});
		score['score'] = 2;
		score['rankHigh'] = [pair[0]];
		score['kickers'] = kickers;
		score['desc'] = "One Pair";
		return score;
	}
	//High card
	else if(numbers.length == 5){
		score['score'] = 1;
		score['rankHigh'] = h.numbers;
		score['desc'] = "High card";
		return score;
	}
	console.log("SHOULDN'T GET HERE");
}
function isFlush_(parsedHand){
	var isFlush = false;
	var flushSuit = [];
	for(var i=0; i<Object.keys(parsedHand).length; i++){
		var key = Object.keys(parsedHand)[i];
		var suit = parsedHand[key];
		for(var y=0; y<suit.length; y++){
			if(flushSuit.indexOf(suit[y]) < 0){
				flushSuit.push(suit[y]);
			}
		}
	}
	if(flushSuit.length == 1){
		isFlush = true;
	}
	return isFlush;
}
function isStraight_(parsedHand){
	if(parsedHand.numbers.length != 5){
		return false;
	}
	if(parsedHand.numbers[0] - parsedHand.numbers[4] == 4){
		return true;
	}
	return false;
}

function parseHand(hand){
	//Hand - [ '7C', '8C', '5C', 'QD', '6C' ]
	var h = { hand: {}};
	for(var i=0; i<hand.length; i++){
		var suit = [];
		var card = hand[i];

		var n = card.substring(0,1);
		if(n == "T") n="10";
		else if(n == "J") n="11";
		else if(n == "Q") n="12";
		else if(n == "K") n="13";
		else if(n == "A") n="14";
		var s = card.substring(1,2);
		if(h.hand[n]){
			h.hand[n].push(s);
		}
		else{
			h.hand[n] = [s];
		}
	}

	var conv = [];
	var numbers = Object.keys(h.hand);
	for(var i=0; i<numbers.length; i++){
		conv.push(parseInt(numbers[i], 10));
	}
	conv.sort(function(a,b){return b-a});
	h['numbers'] = conv;
	return h;
}
