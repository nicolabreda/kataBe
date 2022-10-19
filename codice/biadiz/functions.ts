import { Console } from "console";

export const binaryToDecimal = (str: string, index = 0): number => {
  if (str.length > 1) {
    return (
      Number(str.charAt(str.length - 1)) * Math.pow(2, index) +
      binaryToDecimal(str.slice(0, -1), index + 1)
    );
  } else {
    return Number(str[0]) * Math.pow(2, index);
  }
};

export const decToBinary = (num: number) => {
  return num.toString(2);
};

export const hexToDecimal = (str: string) => {
  return parseInt(str, 16);
};

export const getVersion = (stream: string) => {
  if (stream?.length >= 3) {
    return binaryToDecimal(stream.slice(0, 3));
  }
};

export const getNumberPackage = (stream: string) => {
  if (stream?.length >= 6) {
    return binaryToDecimal(stream.slice(3, 6));
  }
};

export const getBinaryPackage = (
  stream: string,
  numberPackage: number,
  index = 0
) => {
  const baseIndex = 6;
  if (stream?.length >= baseIndex + (index + 1) * numberPackage) {
    return stream.slice(
      baseIndex + index * numberPackage,
      baseIndex + (index + 1) + numberPackage
    );
  }
  return "";
};

export const hexToBinary = (s: string) => {
  let binaryString = "";

  for (let i = 0; i < s.length; i++) {
    switch (s.charAt(i)) {
      case "0":
        binaryString += "0000";
        break;
      case "1":
        binaryString += "0001";
        break;
      case "2":
        binaryString += "0010";
        break;
      case "3":
        binaryString += "0011";
        break;
      case "4":
        binaryString += "0100";
        break;
      case "5":
        binaryString += "0101";
        break;
      case "6":
        binaryString += "0110";
        break;
      case "7":
        binaryString += "0111";
        break;
      case "8":
        binaryString += "0111";
        break;
      case "9":
        binaryString += "1000";
        break;
      case "A":
        binaryString += "1001";
        break;
      case "B":
        binaryString += "1010";
        break;
      case "C":
        binaryString += "1011";
        break;
      case "D":
        binaryString += "1100";
        break;
      case "E":
        binaryString += "1101";
        break;
      case "F":
        binaryString += "1111";
        break;
      default:
        break;
    }
  }

  return binaryString;
};

export const step2Conversion = (hexString: string) => {
  const binaryString = hexToBinary(hexString);
  const version = getVersion(binaryString);
  //const numberPackage = getNumberPackage(binaryString); //always 4
  let index = 0;
  let binaryResult = "";
  let next = "";

  do {
    const group = getBinaryPackage(binaryString, 5, index);
    next = group.charAt(0);
    binaryResult += group.slice(1, 5);
    index++;
  } while (next === "1");

  return "V" + version + "-" + binaryToDecimal(binaryResult);
};
