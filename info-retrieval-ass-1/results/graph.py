import matplotlib.pyplot as plt

def graphData(graph_title, graph_x_label, graph_y_label, x_coords, y_coords):
    plt.title(graph_title)
    plt.xlabel(graph_x_label)
    plt.ylabel(graph_y_label)

    plt.plot(x_coords, y_coords[0], label = "Eng Analyzer - BM25 Sim", linestyle = "-")
    plt.plot(x_coords, y_coords[1], label = "Eng Analyzer - Classic Sim", linestyle = "-")
    plt.plot(x_coords, y_coords[2], label = "Eng Analyzer - LMD Sim", linestyle = "-")
    plt.plot(x_coords, y_coords[3], label = "Simple Analyzer - BM25 Sim", linestyle = "--")
    plt.plot(x_coords, y_coords[4], label = "Simple Analyzer- Classic Sim", linestyle = "--")
    plt.plot(x_coords, y_coords[5], label = "Simple Analyzer - LMD Sim", linestyle = "--")

    plt.legend()
    plt.show()

def main():
    rp_x_coords = [0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1]
    ppd_x_coords = [5, 10, 15, 20, 30, 100, 200, 500, 1000]
    
    rp_y_coords = [
        [0.8517, 0.8277, 0.7413, 0.6204, 0.5183, 0.4497, 0.3524, 0.2818, 0.1984, 0.1382, 0.1227],
        [0.8223, 0.7997, 0.6892, 0.5594, 0.4431, 0.3765, 0.2998, 0.2434, 0.1597, 0.1094, 0.0998],
        [0.7458, 0.7221, 0.6298, 0.5241, 0.4237, 0.3639, 0.2674, 0.2242, 0.1425, 0.0984, 0.0892],
        [0.8095, 0.7803, 0.6758, 0.5534, 0.4556, 0.3936, 0.2815, 0.2265, 0.1558, 0.1106, 0.0990],
        [0.5936, 0.5602, 0.4664, 0.3530, 0.2474, 0.2107, 0.1566, 0.1298, 0.0838, 0.0610, 0.0538],
        [0.7446, 0.7155, 0.6145, 0.4728, 0.3960, 0.3349, 0.2529, 0.1925, 0.1264, 0.0962, 0.0835]
        ]
    
    ppd_y_coords = [
        [0.4651, 0.3183, 0.2524, 0.2075, 0.1558, 0.0533, 0.0266, 0.0107, 0.0053],
        [0.4175, 0.2929, 0.2291, 0.1929, 0.1500, 0.0510, 0.0255, 0.0102, 0.0051],
        [0.3778, 0.2659, 0.2090, 0.1734, 0.1315, 0.0464, 0.0232, 0.0093, 0.0046],
        [0.4444, 0.2976, 0.2296, 0.1921, 0.1450, 0.0500, 0.0250, 0.0100, 0.0050],
        [0.2714, 0.1960, 0.1683, 0.1480, 0.1146, 0.0413, 0.0206, 0.0083, 0.0041],
        [0.3762, 0.2563, 0.2079, 0.1698, 0.1267, 0.0452, 0.0226, 0.0090, 0.0045]
        ]
    
    #graphing Recall vs Precision plot
    graphData("Recall vs Precision", "Recall", "Precision", rp_x_coords, rp_y_coords)

    #graphing Precision Per Document Fetched plot
    graphData("Precision Per Document Fetched", "Documents Fetched", "Precision", ppd_x_coords, ppd_y_coords)

if __name__ == "__main__":
    main()