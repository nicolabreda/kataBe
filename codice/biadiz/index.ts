import {
  binaryToDecimal,
  decToBinary,
  getBinaryPackage,
  getNumberPackage,
  getVersion,
  hexToBinary,
  hexToDecimal,
  step2Conversion,
} from "./functions";

console.log("STEP 1 ---------");
/* STEP 1 */
console.log(binaryToDecimal("11"));
console.log(binaryToDecimal("100101100011"));
console.log(binaryToDecimal("100101001001001100011"));
console.log(
  binaryToDecimal("100101001001001010010010001000001000100010100011")
);

console.log("STEP 2 ---------");

/* STEP 2 */
console.log("304: " + step2Conversion("304"));
console.log("9227: " + step2Conversion("9227"));
console.log("D25130: " + step2Conversion("D25130"));
console.log("F31FE66F790C: " + step2Conversion("F31FE66F790C"));
console.log("52D084A5BA6E69: " + step2Conversion("52D084A5BA6E69"));
