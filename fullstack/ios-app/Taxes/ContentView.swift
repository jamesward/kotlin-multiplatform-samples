import SwiftUI
import TaxesShared

struct ContentView: View {
    @State private var taxRegion: String = ""
    @State private var taxRate: Double?
    
    var body: some View {
        VStack {
            Text("Calculate Taxes")
            
            TextField("Tax Region", text: $taxRegion)
                .border(.secondary)
                .textFieldStyle(.roundedBorder)
                .padding(20)
            
            Button("Get Taxes") {
                taxRate = TaxCalculator().taxRate(
                    taxRegion: TaxRegion(id: taxRegion)
                )
            }.buttonStyle(.bordered)
                .disabled(taxRegion.isEmpty)
            
            taxRate.map {
                Text("Tax Rate: \(Int(round($0 * 100)))%")
            }
        }
    }
}

struct ContentView_Preview:
    PreviewProvider {
    static var previews: some
    View {
        ContentView()
    }
}
